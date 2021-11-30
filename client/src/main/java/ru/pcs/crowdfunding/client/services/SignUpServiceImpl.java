package ru.pcs.crowdfunding.client.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pcs.crowdfunding.client.domain.Client;
import ru.pcs.crowdfunding.client.dto.SignUpForm;
import ru.pcs.crowdfunding.client.repositories.ClientsRepository;


@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {
    private final ClientsRepository clientsRepository;

    @Override
    public SignUpForm signUp(SignUpForm form) {
        Client newClient = Client.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .country(form.getCountry())
                .city(form.getCity())
                .build();

        clientsRepository.save(newClient);
        return SignUpForm.from(newClient);
    }
}
