package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    private SingletonService(){}

    public  void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

    //자바 스태틱 영역

    public static SingletonService getInstance() {
        return instance;
    }

}
