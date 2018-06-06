package sslRel.config;

import javax.servlet.http.HttpServletRequest;
public class Permission {
    public static boolean check(HttpServletRequest request){

        String _action = request.getParameter("_urlaction");
        String _token = request.getParameter("_token");

        DBHelper db = new DBHelper();
        db.connect();
        String user_id = db.query("SELECT * FROM acesso.sslrel_tokens WHERE token='"+_token+"'").get(0).get(0);
        db.query("DELETE FROM acesso.sslrel_tokens WHERE token='"+_token+"'");
        String query="SELECT count(func.ref_ref_cod_pessoa_fj) FROM portal.menu_funcionario as func JOIN portal.menu_submenu as menu ON func.ref_cod_menu_submenu=menu.cod_menu_submenu WHERE menu.arquivo like '%"+_action+"%' AND func.ref_ref_cod_pessoa_fj='"+user_id+"' AND (func.cadastra=1 OR func.exclui=1)";
        int num = Integer.parseInt(db.query(query).get(0).get(0));
        return num > 0;
    }
}
