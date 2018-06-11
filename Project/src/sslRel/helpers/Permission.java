package sslRel.helpers;

import sslRel.helpers.DBHelper;

import javax.servlet.http.HttpServletRequest;

public class Permission {

    public static int GUEST=0;//Pode fazer nada, só visualiza;
    public static int ADMIN=1;//Ou cadastra ou exclui, nunca os dois;
    public static int CADASTRAR=2;//Só cadastra;
    public static int EXCLUIR=3;//Só exclui;
    public static int SUPERADMIN=4;//Faz tudo;

    public static boolean check(HttpServletRequest request,int type){
        String _action = request.getParameter("_urlaction");
        String _token = request.getParameter("_token");

        int A=((type==GUEST)||(type==EXCLUIR))?0:1;
        int B=((type==SUPERADMIN)||(type==EXCLUIR))?1:0;

       String mainFunc = "(func.cadastra=? AND func.exclui=?)";
       String adminFunc= "("+mainFunc+"OR"+mainFunc+")";

        DBHelper db = new DBHelper();
        db.connect();
        int user_id = Integer.parseInt(db.query("SELECT * FROM acesso.sslrel_tokens WHERE token=?",_token).get(0).get(0));
        db.query("DELETE FROM acesso.sslrel_tokens WHERE token=?",_token);

        String numQuery = "SELECT count(func.ref_ref_cod_pessoa_fj) FROM portal.menu_funcionario as func JOIN portal.menu_submenu as menu ON func.ref_cod_menu_submenu=menu.cod_menu_submenu WHERE menu.arquivo like ? AND func.ref_ref_cod_pessoa_fj=? AND ";

        int num=0;
        if(ADMIN==type){
           num = Integer.parseInt(db.query((numQuery+adminFunc),"%"+_action+"%",user_id,A,B,(1-A),(1-B)).get(0).get(0));
        }else{
           num = Integer.parseInt(db.query((numQuery+mainFunc),"%"+_action+"%",user_id,A,B).get(0).get(0));
        }

        return num > 0;
    }


    public static boolean isGuest(HttpServletRequest request){//mesmo que ((Cadastrar==0) AND (Excluir==0))
       return check(request,GUEST);
    }
    public static boolean isAdmin(HttpServletRequest request){//mesmo que (((Cadastrar==0) AND (Excluir==1)) OR ((Cadastrar==1) AND (Excluir==0)));
        return check(request,ADMIN);
    }
    public static boolean isCadAdmin(HttpServletRequest request){//Mesmo que ((Cadastrar==1) AND (Excluir==0))
        return check(request,CADASTRAR);
    }
    public static boolean isExcAdmin(HttpServletRequest request){// Mesmo que ((Cadastrar==0) AND (Excluir==1))
        return check(request,EXCLUIR);
    }
    public static boolean isSuperAdmin(HttpServletRequest request){//Mesmo que ((Cadastrar==1) AND (Excluir==1))
        return check(request,SUPERADMIN);
    }
    public static boolean isNotGuest(HttpServletRequest request){//Mesmo que ((Cadastrar==1) OR (Excluir==1))
        return !isGuest(request);
    }
    public static boolean isAny(HttpServletRequest request){//Mesmo que ((Cadastrar==1) OR (Cadastrar==0) OR (Excluir==1) OR (Excluir==0))
        return true;
    }
}
