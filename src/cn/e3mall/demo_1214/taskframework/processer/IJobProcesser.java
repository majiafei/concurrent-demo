package cn.e3mall.demo_1214.taskframework.processer;


import cn.e3mall.demo_1214.taskframework.entity.TaskResult;

/**
 * @ClassName: IJobProcesser
 * @Auther: admin
 * @Date: 2020/1/15 11:00
 * @Description:
 */
public interface IJobProcesser<R, T> {

    TaskResult<R> execute(T data);

}
