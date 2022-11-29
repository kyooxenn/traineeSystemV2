package trainee.system.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import trainee.system.DTO.InGroupPerformanceDTO;
import trainee.system.mapper.InGroupPerformanceMapper;
import trainee.system.service.iface.InGroupPerformancesService;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class InGroupPerformancesServiceImpl implements InGroupPerformancesService {


    @Resource
    InGroupPerformanceMapper inGroupPerformanceMapper;


    public InGroupPerformanceDTO groupPerformance(InGroupPerformanceDTO inGroupPerformanceDTO) {

        List<InGroupPerformanceDTO> x = inGroupPerformanceMapper.existById(inGroupPerformanceDTO);
        boolean userRole = inGroupPerformanceMapper.selectUserByRole(inGroupPerformanceDTO);
        if (userRole) {
            for (InGroupPerformanceDTO vv : x) {
                int gg = vv.getTraineeEvaluationId();

                if (!x.isEmpty()) {
                    inGroupPerformanceDTO.setTraineeUserId(gg);
                    inGroupPerformanceDTO.setEvaluatorUserId(inGroupPerformanceDTO.getEvaluatorUserId());
                    inGroupPerformanceDTO.setWorkAttitude(inGroupPerformanceDTO.getWorkAttitude());
                    inGroupPerformanceDTO.setProfessionalLevel(inGroupPerformanceDTO.getProfessionalLevel());
                    inGroupPerformanceDTO.setPersonalGrowth(inGroupPerformanceDTO.getPersonalGrowth());
                    inGroupPerformanceDTO.setTeamWork(inGroupPerformanceDTO.getTeamWork());
                    inGroupPerformanceDTO.setWorkUnderPressure(inGroupPerformanceDTO.getWorkUnderPressure());
                    inGroupPerformanceDTO.setCreatedAt(LocalDateTime.now());
                    inGroupPerformanceDTO.setCreatedBy(getUsername());

                    inGroupPerformanceMapper.inGroupPerf(inGroupPerformanceDTO);
                }
            }
        } else {
            boolean user1 = inGroupPerformanceMapper.selectUser(inGroupPerformanceDTO);
            if(user1){
                inGroupPerformanceDTO.setTraineeUserId(inGroupPerformanceDTO.getTraineeUserId());
                inGroupPerformanceDTO.setCreatedAt(LocalDateTime.now());
                inGroupPerformanceMapper.insertRecord(inGroupPerformanceDTO);

                inGroupPerformanceDTO.setEvaluatorUserId(inGroupPerformanceDTO.getEvaluatorUserId());
                inGroupPerformanceDTO.setWorkAttitude(inGroupPerformanceDTO.getWorkAttitude());
                inGroupPerformanceDTO.setProfessionalLevel(inGroupPerformanceDTO.getProfessionalLevel());
                inGroupPerformanceDTO.setPersonalGrowth(inGroupPerformanceDTO.getPersonalGrowth());
                inGroupPerformanceDTO.setTeamWork(inGroupPerformanceDTO.getTeamWork());
                inGroupPerformanceDTO.setWorkUnderPressure(inGroupPerformanceDTO.getWorkUnderPressure());
                inGroupPerformanceDTO.setCreatedAt(LocalDateTime.now());
                inGroupPerformanceDTO.setCreatedBy(getUsername());

                inGroupPerformanceMapper.inGroupPerfNewTraineeId(inGroupPerformanceDTO);
            }
        }

        return null;

    }


    String getUsername(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName="";
        if(principal instanceof UserDetails) {
            userName =((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }

        return userName;
    }


}
