package com.luv4code.beerorderservice.sm.actions;

import com.lfc.brewery.model.events.AllocateOrderRequest;
import com.luv4code.beerorderservice.config.JmsConfig;
import com.luv4code.beerorderservice.domain.BeerOrder;
import com.luv4code.beerorderservice.domain.BeerOrderEventEnum;
import com.luv4code.beerorderservice.domain.BeerOrderStatusEnum;
import com.luv4code.beerorderservice.repositories.BeerOrderRepository;
import com.luv4code.beerorderservice.services.BeerOrderManagerImpl;
import com.luv4code.beerorderservice.web.mappers.BeerOrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class AllocateOrderAction implements Action<BeerOrderStatusEnum, BeerOrderEventEnum> {

    private final JmsTemplate jmsTemplate;
    private final BeerOrderRepository beerOrderRepository;
    private final BeerOrderMapper beerOrderMapper;

    @Override
    public void execute(StateContext<BeerOrderStatusEnum, BeerOrderEventEnum> context) {
        String beerOrderId = (String) context.getMessage().getHeaders().get(BeerOrderManagerImpl.ORDER_ID_HEADER);
        Optional<BeerOrder> beerOrderOptional = beerOrderRepository.findById(UUID.fromString(beerOrderId));

        beerOrderOptional.ifPresentOrElse(beerOrder -> {
            jmsTemplate.convertAndSend(JmsConfig.ALLOCATE_ORDER_QUEUE,
                    AllocateOrderRequest.builder()
                            .beerOrderDto(beerOrderMapper.beerOrderToDto(beerOrder))
                            .build());
            log.debug("Sent Allocation Request for order id: " + beerOrderId);
        }, () -> log.error("Beer Order Not Found!"));
    }
}