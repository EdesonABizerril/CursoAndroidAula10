package foo.maddo.cursoandroidaula10.dao;

import android.content.ContentValues;
import android.content.Context;

import foo.maddo.cursoandroidaula10.datamodel.DataModel;
import foo.maddo.cursoandroidaula10.datasource.DataSource;
import foo.maddo.cursoandroidaula10.model.Login;

/**
 * Created by maddo on 03/05/15.
 */
public class LoginDAO {


    DataSource ds;
    ContentValues values;

    public LoginDAO(Context context){

        ds = new DataSource(context);

    }

    public boolean adicionar(Login obj){

        boolean retorno = false;

        values = new ContentValues();

        values.put(DataModel.getLOGIN(),obj.getLogin());
        values.put(DataModel.getSENHA(),obj.getSenha());

        try {
            ds.persist(values,DataModel.getTABELA_LOGIN());
            retorno = true;
        }catch (Exception e){

        }

        return retorno;
    }
}


