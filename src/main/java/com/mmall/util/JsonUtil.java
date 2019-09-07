package com.mmall.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import java.io.IOException;
import java.text.SimpleDateFormat;

@Slf4j
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    //首先，你需要知道static{}（静态代码块）在程序加载中static是先于构造方法加载的，并且只会加载一次。
    //两外static块中只能使用static修饰的属性。
    static {
        //序列化的时候序列对象的所有属性,对象的所有字段全部列入
        objectMapper.setSerializationInclusion(Inclusion.ALWAYS);
        //取消默认转换timestamps形式
        //取消时间的转化格式,默认是时间戳,可以取消,同时需要设置要表现的时间格式
        objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,false);
        //如果是空对象的时候,不抛异常
        //忽略空Bean转json的错误
        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);

        //所有的日期格式都统一为一下的样式 yyyy-MM-dd HH:mm:ss
        objectMapper.setDateFormat(new SimpleDateFormat(DateTimeUtil.STANDARD_FORMAT));

        //反序列化的时候如果多了其他属性,不抛出异常
        //忽略在json字符串存在，但在java对象中不存在对应属性的情况。防止错误
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    }

    public static <T> String obj2StringPretty(T obj){
        if (obj==null){
            return null;

        }
        try {
            return obj instanceof String ? (String)obj:objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            log.warn("parse Object to String error",e);
            return null;
        }
    }


    public static <T> T string2Obj(String str,Class<T> clazz){
        if(StringUtils.isEmpty(str)){
            return null;
        }

        try {
            return clazz.equals(String.class)? (T)str : objectMapper.readValue(str,clazz);
        } catch (Exception e) {
            log.warn("Parse String to Object error");
            return null;

        }

    }




}