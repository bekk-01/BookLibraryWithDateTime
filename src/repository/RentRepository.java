package repository;

import model.Rent;

public class RentRepository extends BaseRepository<Rent>{
    private static final RentRepository rentRepository = new RentRepository();
    public static RentRepository getInstance(){
        return rentRepository;
    }
    private RentRepository(){

    }
}
