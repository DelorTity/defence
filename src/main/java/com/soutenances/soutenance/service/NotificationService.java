package com.soutenances.soutenance.service;

import com.soutenances.soutenance.dto.DefenseDto;

public interface NotificationService {

    void SentNotificationMail(DefenseDto defenseDto);
}
