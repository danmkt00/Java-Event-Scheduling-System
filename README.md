# 📅 Event Scheduling System API

A simple REST API for managing events and attendees using **Spring Boot** and **Spring Data JPA**.  
Supports creating events, validating input, enforcing capacity rules, and listing all events.  

---

## 🚀 Features

- Create events  
- List all events  
- Validation rules:  
  - Event date must be in the future  
  - Capacity ≥ 1  
  - Prevent exceeding capacity  
- DTO → Mapper → Entity workflow  
- Custom exceptions: `EventDateInPastException`, `EventEndBeforeStartException`  

---

## 🧩 Endpoints

| Method | Endpoint          | Description |
|--------|-----------------|-------------|
| `POST` | `/events`        | Create a new event |
| `GET`  | `/events`        | Get all events (404 if none) |
| `GET`  | `/events/{id}`   | Get event by ID |

---

## 📝 Event JSON Example

```json
{
  "title": "Spring Boot Workshop",
  "startDateTime": "2025-12-05T10:00:00",
  "endDateTime": "2025-12-05T12:00:00",
  "capacity": 50
}
