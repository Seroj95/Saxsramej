package Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import Model.Car;
import Utils.Utils;


public class DataBaseHandler extends SQLiteOpenHelper {
    public DataBaseHandler( Context context ) {
        super(context, Utils.DATABASE_NAME, null, Utils.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CARS_TABLE="CREATE TABLE "+Utils.TABLE_NAME+"("+Utils.KEY_ID+" INTAGER PRIMARY KEY," +
                Utils.KEY_NAME+"TEXT"
                +Utils.KEY_PRICE+" TEXT"+")";
        db.execSQL(CREATE_CARS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Utils.TABLE_NAME);
        onCreate(db);
    }
//        //Crud
//        //Create Read,Update,Delete;
    public void addCar(Car car){
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
contentValues.put(Utils.KEY_NAME,car.getName());
contentValues.put(Utils.KEY_PRICE,car.getPrice());
 db.insert(Utils.TABLE_NAME ,null,contentValues);

db.close();

    }
    public Car getCar(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.query(Utils.TABLE_NAME,new String[]{Utils.KEY_ID,Utils.KEY_NAME,Utils.KEY_PRICE},Utils.KEY_ID+"=?",
                new String[] {String.valueOf(id)},null,null,null,null);
if (cursor!=null){
    cursor.moveToFirst();
}
Car car =new Car(Integer.parseInt(cursor.getString(0))
        ,cursor.getString(1),
        cursor.getString(2));
return car;
    }
public List<Car>getAllCars(){
        SQLiteDatabase db=this.getReadableDatabase();
        List<Car> carList=new ArrayList<>();
       String selectAllCars="SELECT * FROM " +Utils.TABLE_NAME;
       Cursor cursor=db.rawQuery(selectAllCars,null);
       if (cursor.moveToFirst()){
           do{
             Car car =new Car();
             car.setId(Integer.parseInt(cursor.getString(0)));
             car.setName(cursor.getString(1));
             car.setPrice(cursor.getString(2));
             carList.add(car);
           }while (cursor.moveToNext());
       }
       return carList;
}
public  int updateCar(Car car){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Utils.KEY_NAME,car.getName());
        contentValues.put(Utils.KEY_PRICE,car.getPrice());
        return db.update(Utils.TABLE_NAME,contentValues,Utils.KEY_ID+"=?",new String[]{String.valueOf(car.getId())});
}
public void deleteCar(Car car){
    SQLiteDatabase db =this.getWritableDatabase();
    db.delete(Utils.TABLE_NAME,Utils.KEY_ID+"=?",new String[]{String.valueOf(car.getId())});
    db.close();
}
public  int  getCarsCount(){
        SQLiteDatabase db=this.getReadableDatabase();
        String countQuery="SELECT * FROM "+ Utils.TABLE_NAME;
        String table;
        Cursor cursor=db.rawQuery(countQuery,null);
        return  cursor.getCount();
}
}
