package Model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import java.util.List;

import Data.CarDataBase;

public class CarViewModel extends AndroidViewModel {

    private List<Car> cars;
    private static CarDataBase dataBase;

    public List<Car> getCars() {
        return cars;
    }

    public CarViewModel(@NonNull Application application) {
        super(application);
        dataBase = CarDataBase.getInstance(getApplication());
        cars = dataBase.carDao().getAllCars();
    }

    public void insert(Car car){new InsertTask().execute(car);}
    public void delete(Car car){new DeleteTask().execute(car);}
    public void update(Car car){new UpdateTask().execute(car);}

    public class InsertTask extends AsyncTask<Car, Void, Void>{
        @Override
        protected Void doInBackground(Car... cars) {
            if(cars != null && cars.length > 0){
                dataBase.carDao().insert(cars[0]);
            }
            return null;
        }
    }

    public class DeleteTask extends AsyncTask<Car, Void, Void>{
        @Override
        protected Void doInBackground(Car... cars) {
            if(cars != null && cars.length > 0){
                dataBase.carDao().delete(cars[0]);
            }
            return null;
        }
    }

    public class UpdateTask extends AsyncTask<Car, Void, Void>{
        @Override
        protected Void doInBackground(Car... cars) {
            if(cars != null && cars.length > 0){
                dataBase.carDao().update(cars[0]);
            }
            return null;
        }
    }



}
