package trainee.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trainee.system.DTO.InGroupPerformanceDTO;
import trainee.system.service.iface.InGroupPerformancesService;
import trainee.system.vo.ResponseVO;

import javax.annotation.Resource;
import java.util.Collections;

@Slf4j
@RestController
@RequestMapping("/api/trainee-system/criteria")
public class CriteriaController {

    @Resource
    InGroupPerformancesService inGroupPerformancesService;


    @PostMapping("/v1/trainee/in/group/performance")
    public ResponseVO inGroupPerf(@RequestBody InGroupPerformanceDTO inGroupPerformanceDTO){
        inGroupPerformancesService.groupPerformance(inGroupPerformanceDTO);
        return new ResponseVO(200,"Successful Operation", Collections.emptyList());
    }

}
