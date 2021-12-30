package Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.Car;

@Dao
public interface CarDao {

    @Insert
    void insert(Car car);

    @Delete
    void delete(Car car);

    @Update
    void update(Car car);

    @Query("SELECT * FROM cars")
    List<Car> getAllCars();

    @Query("SELECT * FROM cars")
    LiveData<List<Car>> getAllCarsLive();

    @Query("SELECT * FROM cars WHERE car_id ==:car_id")
    public Car getCarId(long car_id);
}
