package work.azhu.springbootnetty.serialize.impl;

import com.alibaba.fastjson.JSON;
import work.azhu.springbootnetty.serialize.Serializer;
import work.azhu.springbootnetty.serialize.SerializerAlgorithm;

/**
 * @Author Azhu
 * @Description //TODO
 * @Date 2019/11/12 20:03
 **/
public class JSONSerializer implements Serializer {
    @Override
    public byte getSerializerAlgorithm() {

        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {

        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {

        return JSON.parseObject(bytes, clazz);
    }
}
