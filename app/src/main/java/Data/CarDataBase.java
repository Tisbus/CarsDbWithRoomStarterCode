package Data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import Model.Car;

@Database(entities = {Car.class}, version = 2)
public abstract class CarDataBase extends RoomDatabase {
    private static CarDataBase carDataBase;
    private static final String DB_NAME = "cars";
    private static final Object LOCK = new Object();
    public static CarDataBase getInstance(Context context){
        synchronized (LOCK){
            if(carDataBase == null){
                carDataBase = Room.databaseBuilder(context.getApplicationContext(), CarDataBase.class, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return carDataBase;
    }
    public abstract CarDao carDao();
}
