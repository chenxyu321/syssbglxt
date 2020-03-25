package com.sys.serviceImpl;
import com.sys.mapper.ClassesMapper;
import com.sys.model.Classes;
import com.sys.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper mapper;
//    @Autowired
//    private RedisTemplate<Object,Object> redisTemplate;
    @Override
    public List<Classes> getClassesList(Map requestparamMap) {
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        List<Classes> list = (List<Classes>) redisTemplate.opsForValue().get("classesList");
//        if (list==null){
//            synchronized (this){
//                list = (List<Classes>) redisTemplate.opsForValue().get("classesList");
//                if (list==null){
//                    list = mapper.getClassesList();
//                    redisTemplate.opsForValue().set("classesList",list);
//                }
//            }
//        }
        return mapper.getClassesList(requestparamMap);
    }

    @Override
    public Classes getClassesById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Classes> getClassesByTeacher(int tid) {
        return mapper.getClassesByTeacher(tid);
    }

    @Override
    public int insertClasses(Classes classes) {
        return mapper.insertSelective(classes);
    }

    @Override
    public int delClasses(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int upClasses(Classes classes) {
        return mapper.updateByPrimaryKeySelective(classes);
    }
}
