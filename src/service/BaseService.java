package service;

import model.BaseModel;
import repository.BaseRepository;

import java.util.ArrayList;
import java.util.UUID;

public abstract class BaseService<T extends BaseModel,R extends BaseRepository<T>> {
    protected R repository;
    public BaseService(R repository){
        this.repository = repository;
    }
    public boolean add(T t){
        if(check(t)){
            return false;
        }
        repository.add(t);
        return true;
    }
    private boolean check(T t){
        return false;
    }
    public void update(UUID id , T t){
        repository.update(id,t);
    }
    public void delete(UUID id){
        repository.delete(id);
    }
    public ArrayList<T> getActive(){
        return repository.getActive();
    }
}
