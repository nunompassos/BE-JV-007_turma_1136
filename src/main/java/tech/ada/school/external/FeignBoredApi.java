package tech.ada.school.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import tech.ada.school.domain.dto.ActivityDto;

@Service
@FeignClient(name = "Activities", url = "https://www.boredapi.com/api/activity")
public interface FeignBoredApi {

    @GetMapping
    ActivityDto getActivity();

}
