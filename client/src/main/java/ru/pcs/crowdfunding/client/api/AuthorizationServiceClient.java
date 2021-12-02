package ru.pcs.crowdfunding.client.api;

import org.springframework.http.ResponseEntity;
import ru.pcs.crowdfunding.client.dto.AuthSignUpRequest;
import ru.pcs.crowdfunding.client.dto.ResponseDto;

public interface AuthorizationServiceClient {
    ResponseEntity<ResponseDto> signUp(AuthSignUpRequest request);
}