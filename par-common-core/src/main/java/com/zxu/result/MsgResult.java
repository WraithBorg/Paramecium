package com.zxu.result;


import com.zxu.constant.PageConst;
import com.zxu.util.CustomUtils;
import com.zxu.util.SprBeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MsgResult<T> {

    private static final Logger logger = LoggerFactory.getLogger(MsgResult.class);
    public static final MsgResult<Object> FAIL = new MsgResult<>(MsgResultType.ERROR);
    public static final MsgResult<Object> DONE = new MsgResult<>(MsgResultType.SUCCESS);

    private T data;
    private String message;
    private String url;
    private MsgResultType type;

    public MsgResult(MsgResultType type) {
        this(null, null, null, type);
    }

    public MsgResult(T data, String message, MsgResultType type) {
        this(data, message, null, type);
    }

    public MsgResult(T data, String message, String[] args, MsgResultType type) {
        this.data = data;
        this.type = type;
        setMessage(message, args);
    }
    public MsgResult(T data, String message, String[] args, MsgResultType type,String url) {
        this.data = data;
        this.type = type;
        this.url = PageConst.WEB_HOST + url;
        setMessage(message, args);
    }

    public static <T> MsgResult<T> fail(String message) {
        return new MsgResult<>(null, message, null, MsgResultType.ERROR);
    }

    public static <T> MsgResult<T> fail(String message, T data) {
        return new MsgResult<>(data, message, null, MsgResultType.ERROR);
    }

    public static <T> MsgResult<T> fail(String message, String[] args, T data) {
        return new MsgResult<>(data, message, args, MsgResultType.ERROR);
    }
    public static MsgResult doneMsg(String  message) {
        return new MsgResult (null, message, null, MsgResultType.SUCCESS);
    }
    public static <T> MsgResult<T> done() {
        return new MsgResult<>(null, null, null, MsgResultType.SUCCESS);
    }

    public static <T> MsgResult<T> done(T data) {
        return new MsgResult<>(data, null, null, MsgResultType.SUCCESS);
    }
    public static <T> MsgResult<T> doneUrl(String url) {
        return new MsgResult<>(null, null, null, MsgResultType.SUCCESS);
    }
    public static <T> MsgResult<T> doneUrl(String message,String url) {
        return new MsgResult<>(null, message, null, MsgResultType.SUCCESS);
    }
    public static <T> MsgResult<T> doneUrl(T data,String url) {
        return new MsgResult(data,   null, null,MsgResultType.SUCCESS,url);
    }
    public static <T> MsgResult<T> doneUrl(T data,String url ,String  message) {
        return new MsgResult(data,   message, null,MsgResultType.SUCCESS,url);
    }
    @SuppressWarnings("unchecked")
    public static <T> MsgResult doneUrl(String datatype, T data, String url) {
        return new MsgResult(CustomUtils.ofMap(datatype, data),   null, null,MsgResultType.SUCCESS,url);
    }
    public static <T> MsgResult<T> done(T data, String message) {
        return new MsgResult<>(data, message, null, MsgResultType.SUCCESS);
    }

    public static <T> MsgResult<T> done(T data, String message, String[] args) {
        return new MsgResult<>(data, message, args, MsgResultType.SUCCESS);
    }

    public static <T> MsgResult<T> warn(String message) {
        return new MsgResult<>(null, message, null, MsgResultType.WARN);
    }

    public static <T> MsgResult<T> warn(String message, T data) {
        return new MsgResult<>(data, message, null, MsgResultType.WARN);
    }

    public static <T> MsgResult<T> warn(String message, String[] args, T data) {
        return new MsgResult<>(data, message, args, MsgResultType.WARN);
    }

    public MsgResult<T> then(MsgResultConsumer<MsgResult<T>> consumer) {
        if (ok()) {
            try {
                consumer.accept(this);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                this.type = MsgResultType.ERROR;
            }
            return this;
        } else {
            return this;
        }
    }

    public <E> MsgResult<E> then(MsgResultFunction<MsgResult<T>, MsgResult<?>> func) {
        if (ok()) {
            try {
                return func.apply(this).transform();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                this.type = MsgResultType.ERROR;
                return this.transform();
            }
        } else {
            return this.transform();
        }
    }

    public MsgResult<T> fail(MsgResultConsumer<MsgResult<T>> consumer) {
        if (!ok()) {
            try {
                consumer.accept(this);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
            return this;
        } else {
            return this;
        }
    }

    public <E> MsgResult<E> fail(MsgResultFunction<MsgResult<T>, MsgResult<?>> func) {
        if (!ok()) {
            try {
                return func.apply(this).transform();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return this.transform();
            }
        } else {
            return this.transform();
        }
    }

    public boolean ok() {
        return type != MsgResultType.ERROR;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        setMessage(message, null);
    }

    public void setMessage(String message, String[] args) {
        try {
            this.message = SprBeanUtil.getMessageSource(message, args);
        } catch (Exception e) {
            this.message = message;
        }
    }

    public <E> MsgResult<E> transform() {
        return new MsgResult<>((E) data, message, type);
    }

    public <E> MsgResult<E> transform(E data) {
        return new MsgResult<>(data, message, type);
    }
    //}}}

    public void setData(T data) {
        this.data = data;
    }

    public MsgResultType getType() {
        return type;
    }

    public void setType(MsgResultType type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "ServiceResult{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", type=" + type +
                '}';
    }
//    # Demo
//    MsgResult.warn("",null).then(e -> {
//        System.out.println("1");
//    }).then(e -> {
//        System.out.println("2");
//        return MsgResult.warn("warn...");
//    }).then(e -> {
//        System.out.println("3");
//        return MsgResult.fail("fail...");
//    }).then(e -> {
//        System.out.println("4");
//    });
}
