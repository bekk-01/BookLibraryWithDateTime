package service;

import model.Rent;
import repository.RentRepository;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class RentService extends BaseService<Rent, RentRepository> {
    private static final RentService rentService = new RentService();
    public static RentService getInstance(){
        return rentService;
    }
    private RentService(){
        super(RentRepository.getInstance());
    }
    public boolean checkPhoneNumber(String s){
        return repository.checkPhoneNumber(s);
    }
}
