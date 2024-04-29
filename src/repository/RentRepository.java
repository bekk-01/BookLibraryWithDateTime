package repository;

import model.Book;
import model.Rent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class RentRepository extends BaseRepository<Rent>{
    private static final RentRepository rentRepository = new RentRepository();
    public static RentRepository getInstance(){
        return rentRepository;
    }
    private RentRepository(){

    }
    public boolean checkPhoneNumber(String s){
        for (Rent datum : data) {
            if(Objects.equals(datum.getPhoneNumber(), s)){
                return true;
            }
        }
        return false;
    }

}
