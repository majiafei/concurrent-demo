package cn.e3mall.demo_1214.threadpool;

import org.omg.SendingContext.RunTime;

import java.sql.Time;
import java.util.concurrent.*;

/**
 * @ClassName: JdkThreadPollTest
 * @Auther: admin
 * @Date: 2020/1/8 13:54
 * @Description:
 */
public class JdkThreadPollTest {

    public static void main(String[] args) {
       // ExecutorService executorService = Executors.newSingleThreadExecutor();
/*        1）如果没有空闲的线程执行该任务且当前运行的线程数少于corePoolSize，则添加新的线程执行该任务。

     （2）如果没有空闲的线程执行该任务且当前的线程数等于corePoolSize同时阻塞队列未满，则将任务入队列，而不添加新的线程。

     （3）如果没有空闲的线程执行该任务且阻塞队列已满同时池中的线程数小于maximumPoolSize，则创建新的线程执行任务。

     （4）如果没有空闲的线程执行该任务且阻塞队列已满同时池中的线程数等于maximumPoolSize，则根据构造函数中的handler指定的策略来拒绝新的任务。
          keepAliveTime：表示空闲线程的存活时间。

        TimeUnitunit：表示keepAliveTime的单位。

        为了解释keepAliveTime的作用，我们在上述情况下做一种假设。假设线程池这个单位已经招了些临时工，但新任务没有继续增加，所以随着每个员工忙完手头的工作，都来workQueue领取新的任务（看看这个单位的员工多自觉啊）。随着各个员工齐心协力，任务越来越少，员工数没变，那么就必定有闲着没事干的员工。这样的话领导不乐意啦，但是又不能轻易fire没事干的员工，因为随时可能有新任务来，于是领导想了个办法，设定了keepAliveTime，当空闲的员工在keepAliveTime这段时间还没有找到事情干，就被辞退啦，毕竟地主家也没有余粮啊！当然辞退到corePoolSize个员工时就不再辞退了，领导也不想当光杆司令啊！

       handler：表示当workQueue已满，且池中的线程数达到maximumPoolSize时，线程池拒绝添加新任务时采取的策略。

       ThreadPoolExecutor.AbortPolicy() 抛出RejectedExecutionException异常
       ThreadPoolExecutor.CallerRunsPolicy() 由向线程池提交任务的线程来执行该任务
       ThreadPoolExecutor.DiscardOldestPolicy() 抛弃最旧的任务（最先提交而没有得到执行的任务）
       ThreadPoolExecutor.DiscardPolicy() 抛弃当前的任务

       */
/*        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 10, 0,
                                                                       TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(20));
        threadPoolExecutor.shutdown();*/
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
