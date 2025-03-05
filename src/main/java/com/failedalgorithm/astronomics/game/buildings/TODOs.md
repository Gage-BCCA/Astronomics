- Implement BuildingSummary and BuildingDetails DTOs
- Finish CRUD operations on Buildings
  - Create request/responses for each
- Implement Table for building storage
- Style classes with section headers


- Pass building DTO on update response
- Unfuck the serialization for BuildingDTOs
  - Currently sends the building DTO and the building into the serialized json
  - Temporarily fixed with the JsonIgnoreProperties statement