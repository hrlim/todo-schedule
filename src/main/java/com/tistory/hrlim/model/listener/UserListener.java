package com.tistory.hrlim.model.listener;

import com.tistory.hrlim.model.domain.Calendar;
import com.tistory.hrlim.model.domain.User;
import com.tistory.hrlim.repository.CalendarRepository;
import com.tistory.hrlim.utils.BeanUtils;

import javax.persistence.PostPersist;

public class UserListener {

    /**
     * User가 생성된 이후에 calendar 자동 생성을 위해 사용되는 함수
     * @param o
     */
    @PostPersist
    public void postPersist(Object o){
        CalendarRepository calendarRepository = BeanUtils.getBean(CalendarRepository.class);

        User user = (User) o;

        Calendar calendar = new Calendar();
        calendar.setUser(user);
        calendar.setName("보람찬 하루를 보내자");
        calendarRepository.save(calendar);
    }
}
