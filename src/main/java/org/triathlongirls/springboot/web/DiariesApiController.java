package org.triathlongirls.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.triathlongirls.springboot.service.diaries.DiariesService;
import org.triathlongirls.springboot.web.dto.DiariesResponseDto;
import org.triathlongirls.springboot.web.dto.DiariesSaveRequestDto;
import org.triathlongirls.springboot.web.dto.DiariesUpdateRequestDto;

@RequiredArgsConstructor
@RestController
public class DiariesApiController {

    private final DiariesService diariesService;

    @PostMapping("/api/v1/diaries")
    public Long save(@RequestBody DiariesSaveRequestDto requestDto) {
        return diariesService.save(requestDto);
    }

    @PutMapping("/api/v1/diaries/{id}")
    public Long update(@PathVariable Long id, @RequestBody DiariesUpdateRequestDto requestDto) {
        return diariesService.update(id, requestDto);
    }

    @GetMapping("/api/v1/diaries/{id}")
    public DiariesResponseDto findById(@PathVariable Long id) {
        return diariesService.findById(id);
    }
}