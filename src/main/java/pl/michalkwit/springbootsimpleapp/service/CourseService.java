package pl.michalkwit.springbootsimpleapp.service;



import java.util.List;

public interface CourseService<T> extends BaseService{

    public List<T> getBought();

    public T buyCourse(int id);
}
