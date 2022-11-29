package trainee.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import trainee.system.DTO.InGroupPerformanceDTO;

import java.util.List;

@Mapper
public interface InGroupPerformanceMapper {
    List<InGroupPerformanceDTO> existById(InGroupPerformanceDTO inGroupPerformanceDTO);

    boolean selectUserByRole(InGroupPerformanceDTO inGroupPerformanceDTO);

    boolean selectUser(InGroupPerformanceDTO inGroupPerformanceDTO);

    void inGroupPerf(InGroupPerformanceDTO inGroupPerformanceDTO);

    void insertRecord(InGroupPerformanceDTO inGroupPerformanceDTO);

}
