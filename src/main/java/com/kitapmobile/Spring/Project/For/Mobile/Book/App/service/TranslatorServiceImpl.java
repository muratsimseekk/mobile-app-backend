package com.kitapmobile.Spring.Project.For.Mobile.Book.App.service;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Translator;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.exception.CommonException;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.repository.TranslatorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TranslatorServiceImpl implements TranslatorService{

    private TranslatorRepository translatorRepository;
    @Override
    public List<Translator> findAll() {
        return translatorRepository.findAll();
    }

    @Override
    public Translator findById(Long id) {
        Optional<Translator> optional = translatorRepository.findById(id);

        if (optional.isPresent()){
            return optional.get();
        }

        throw new CommonException("Girilen id de bir çevirmen bulunamadı . ID : ",id , HttpStatus.NOT_FOUND);

    }

    @Override
    public Translator save(Translator translator) {
        return translatorRepository.save(translator);
    }

    @Override
    public String delete(Long id) {
        Optional<Translator> optional = translatorRepository.findById(id);
        if (optional.isPresent()){
            translatorRepository.delete(optional.get());
            return "Çevirmen silme işlemi başarı ile gerçekleşti .";
        }
        throw new CommonException("Girilen id de bir çevirmen bulunamadı . ID : ",id , HttpStatus.NOT_FOUND);
    }

}
