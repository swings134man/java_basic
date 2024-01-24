package async.compleatable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

/************
 * @info : Java CompletableFuture Basic Example
 * @name : CompletableFuture_1
 * @date : 1/24/24 10:29 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 *
 *  CompletableFuture 는 Java 8 에서 추가된 비동기 처리를 위한 인터페이스이다.
 *  Future 를 확장한 인터페이스로, Future 에서 제공하는 get() 메서드를 통해 비동기 처리 결과를 가져오는 방식이 아닌,
 *  콜백 메서드를 통해 비동기 처리 결과를 가져올 수 있다.
 *      -> 기존의 future.get() 의 경우 작업이 완료될때까지 대기하는 '블로킹' 호출 방식.
 *
 *  CompletableFuture 는 Future 와 달리, 비동기 처리가 완료되었을 때 콜백 메서드를 통해 결과를 반환할 수 있다.
 *  또한 여러 Future 를 조합할 수 있는 기능을 제공한다.
 *
 *  get(): Future 에서 제공하는 get() 메서드를 통해 비동기 처리 결과를 가져올 수 있다.(future 에 존재함)
 *      -> checked Exception, InterruptedException, ExecutionException 발생(예외처리 필요)
 *  join(): get() 메서드와 동일한 기능을 제공하지만, checked Exception 을 발생시키지 않는다. (CompleatableFuture 내부에 존재)
 *      -> unchecked Exception, InterruptedException, ExecutionException 발생(예외처리 필요X)
 *
 *
 *  **Async 메서드는 비동기로 실행되는 메서드이며, 기본적으로 ForkJoinPool.commonPool() 에서 실행되고 기존의 Thread 를 사용한다.
 *      -> thenApply, thenAccept, thenRun -> Async 메서드가 아님
 ************/
public class CompletableFuture_1 {

    static Logger log = Logger.getLogger("CompletableFuture_1");

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "hello?");
//        String s = completableFuture.get();
//        System.out.println("s = " + s);

        /**
         * 1. supplyAsync(): 비동기로 작업을 실행하고 결과를 반환하는 메서드
         * 2. runAsync(): 비동기로 작업을 실행하고 결과를 반환하지 않는 메서드
         */
        CompletableFuture<Void> supplyAsync = CompletableFuture.supplyAsync(() -> {
            log.info("supplyAsync");
            System.out.println("Current Thread" + Thread.currentThread().getName());
            return "Hello";


            // -------------------------------------- 콜백 작업 파트 --------------------------------------
            // thenApply() 메서드는 콜백 메서드로, 리턴값이 있는 경우 사용한다.
            // 앞선 계산의 결과를 콜백 함수로 전달된 Function을 실행, 결과를 반환한다.
        }).thenApplyAsync(s -> {
            log.info("thenApplyAsync : " + s);
            System.out.println("Current Thread" + Thread.currentThread().getName());
            return s + "world";

            // thenAcceptAsync() 메서드는 콜백 메서드로, 리턴값이 없는 경우 사용한다. 비동기로 실행된다.
        }).thenAcceptAsync(s -> {
            log.info("thenAccept: " + s);
            System.out.println("Current Thread" + Thread.currentThread().getName());
            //return ""; // ERROR!

            // thenRun(): 함수형 인터페이스를 파라미터로 받는다, 반환값을 받지 않으며, 작업 처리후 리턴값이 없는 경우 사용함.
        }).thenRun(() -> System.out.println("thenRun"));

        System.out.println("msg = " + supplyAsync.join());
    }


}
