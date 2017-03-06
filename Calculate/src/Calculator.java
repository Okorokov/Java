
public class Calculator {
    private int result;

    public void add(int ... params){
        for(Integer param : params){
            this.result+=param;
        }
    }
    public void minus(int ... params){
        this.result=2*params[0];
        for(Integer param : params){
            this.result-=param;
        }
    }
    public void umnojenie(int ... params){
        this.result=1;
        for(Integer param : params){
            this.result*=param;
        }
    }
    public void div(int ... params){
        this.result=params[0]*params[0];
        for(Integer param : params){
            this.result/=param;
        }
    }

    public int getResult() {
        return this.result;
    }
    public int clear(){
        return this.result=0;
    }
}
