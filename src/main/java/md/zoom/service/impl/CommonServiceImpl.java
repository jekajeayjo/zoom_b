package md.zoom.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import md.zoom.config.mapping.AppMapper;
import md.zoom.model.dto.LanguageDto;
import md.zoom.repository.LanguageRepository;
import md.zoom.service.CommonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommonServiceImpl implements CommonService {
    private final AppMapper appMapper;

    private final LanguageRepository languageRepository;

    @Override
    public List<LanguageDto> getLanguageList() {
        return languageRepository.findAll().stream().map(appMapper::map).toList();
    }
}
