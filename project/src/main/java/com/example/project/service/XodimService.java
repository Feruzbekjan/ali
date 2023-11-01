package com.example.project.service;

import com.example.project.entity.Xodim;
import com.example.project.repository.XodimRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.NoSuchElementException;

@Service
public class XodimService implements UserDetailsService {
    private final XodimRepository xodimRepository;



    public XodimService(XodimRepository xodimRepository) {
        this.xodimRepository = xodimRepository;

    }

    public Xodim save(Xodim xodim){
        return xodimRepository.save(xodim);
    }
    public boolean chekAge(Integer tugilgan_yili){
        return Year.now().getValue() - tugilgan_yili<18;
    }

    public Xodim updete(Long id,Xodim updetexodim){
        Xodim xodim=xodimRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Xodim with ID " + id + " not found"));
        xodim.setBolim(updetexodim.getBolim());
        xodim.setLavozim(updetexodim.getLavozim());
        xodim.setManzili(updetexodim.getManzili());
        xodim.setPasport(updetexodim.getPasport());
        xodim.setAge(updetexodim.getAge());

        return xodimRepository.save(xodim);
    }
    public void deleteById(Long id){
        xodimRepository.deleteById(id);
    }
    public Xodim finById(Long id){
      return xodimRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Xodim with ID " + id + " not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
