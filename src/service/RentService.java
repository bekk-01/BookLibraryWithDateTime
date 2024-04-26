package service;

import model.Rent;
import repository.RentRepository;

public class RentService extends BaseService<Rent, RentRepository> {
    private static final RentService rentService = new RentService();
    public static RentService getInstance(){
        return rentService;
    }
    private RentService(){
        super(RentRepository.getInstance());
    }
}
