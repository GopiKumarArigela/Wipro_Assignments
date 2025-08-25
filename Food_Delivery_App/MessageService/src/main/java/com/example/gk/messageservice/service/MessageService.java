package com.example.gk.messageservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gk.messageservice.dto.MessageRequestDTO;
import com.example.gk.messageservice.dto.MessageResponseDTO;
import com.example.gk.messageservice.entities.Message;
import com.example.gk.messageservice.enums.MessageStatus;
import com.example.gk.messageservice.exception.ResourceNotFoundException;
import com.example.gk.messageservice.repository.MessageRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    @Transactional
    public MessageResponseDTO sendMessage(MessageRequestDTO request) {
        // Here you can call other services to validate sender/receiver/order/payment/delivery
        // Example: using RestTemplate or WebClient
        // restTemplate.getForObject("http://customer-service/api/customers/" + request.getSenderId(), Customer.class);

        Message message = Message.builder()
                .senderId(request.getSenderId())
                .receiverId(request.getReceiverId())
                .orderId(request.getOrderId())
                .paymentId(request.getPaymentId())
                .deliveryId(request.getDeliveryId())
                .content(request.getContent())
                .status(MessageStatus.SENT)
                .timestamp(LocalDateTime.now())
                .build();

        Message saved = messageRepository.save(message);
        return mapToDTO(saved);
    }

    public MessageResponseDTO getMessage(Long id) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Message not found with id: " + id));
        return mapToDTO(message);
    }

    public List<MessageResponseDTO> getMessagesBySender(Long senderId) {
        return messageRepository.findBySenderId(senderId)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<MessageResponseDTO> getMessagesByReceiver(Long receiverId) {
        return messageRepository.findByReceiverId(receiverId)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<MessageResponseDTO> getMessagesByOrder(Long orderId) {
        return messageRepository.findByOrderId(orderId)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Transactional
    public MessageResponseDTO updateStatus(Long id, MessageStatus status) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Message not found with id: " + id));
        message.setStatus(status);
        return mapToDTO(messageRepository.save(message));
    }

    @Transactional
    public void deleteMessage(Long id) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Message not found with id: " + id));
        messageRepository.delete(message);
    }

    private MessageResponseDTO mapToDTO(Message message) {
        return MessageResponseDTO.builder()
                .id(message.getId())
                .senderId(message.getSenderId())
                .receiverId(message.getReceiverId())
                .orderId(message.getOrderId())
                .paymentId(message.getPaymentId())
                .deliveryId(message.getDeliveryId())
                .content(message.getContent())
                .status(message.getStatus())
                .timestamp(message.getTimestamp())
                .build();
    }
}
