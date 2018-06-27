package Tests;

import sslRel.helpers.DBHelper;

import static org.mockito.Mockito.*;

public class MockTest  {

    public static void main (String[] args){
        boolean con;




        DBHelper db = mock(DBHelper.class);
        when(db.connect()).thenReturn(true);
        con=db.connect();
        System.out.println("MENSAGEM:  "+con);

    }

}
