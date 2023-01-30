package com.example.UserDetails.service;

import com.example.UserDetails.entity.UserEntity;
import com.example.UserDetails.mapper.UserMapper;
import com.example.UserDetails.model.UserModel;
import com.example.UserDetails.model.UserResponse;
import com.example.UserDetails.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserService
    {


        @Autowired
        private UserMapper userMapper;

        @Autowired
        private UserRepository userRepository;

        @Value("${topic.name.producer}")
        private String topicName;

        private final KafkaTemplate<String, String> kafkaTemplate;

        public UserResponse createData(UserModel userModel)
        {
            UserEntity userEntity=null;
            userEntity=userMapper.modelToEntity(userModel);
            userRepository.save(userEntity);

            UserResponse userResponse =new UserResponse();
            userResponse.setId(userEntity.getId());

            log.info("Posting.......");
            return userResponse;

        }

      /*  @Scheduled(cron = "0/10 * * * * *")
        public UserModel getByDate(Date birthday) {
            Optional<UserEntity>userEntityOptional=userRepository.findByDate(birthday);
            UserModel userModel=new UserModel();
            if (userEntityOptional.isPresent())
            {
                userModel=userMapper.entityToModel(userEntityOptional.get());
                log.info("Fetching.........");
            }
            else
            {
                log.info("Date not found");
            }
            return  userModel;
        }



        @Scheduled(cron = "0/10 * * * * *")
        public List<?> findByDayMonth(MonthDay monthDay)
        {
           List<?> entityList = new ArrayList<>();
            List<?> personEntityList = userRepository.findAllByDayMonth(monthDay);
            Date date = new Date();
            kafkaTemplate.send(topicName, entityList.toString());
            log.info(" "+topicName);
            log.info("" + date);
            log.info("Fetching.....");

            return personEntityList;
        }*/

        @Scheduled(cron = "0/10 * * * * *")
        public void findByDayMonth()
        {
            int cout=0;
            List<String>entityList =  userRepository.findAllByDayMonth();

            for (String mail:entityList )
            {
                kafkaTemplate.send(topicName, mail);

            }
            ++cout;
            log.info("Fetching....."+cout);


        }

    }
