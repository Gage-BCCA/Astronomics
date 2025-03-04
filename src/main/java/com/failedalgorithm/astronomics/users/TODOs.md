- See if the API Key filter can only be used if the request does not have a "permit all" for it
  - Right now, even if you hit a public endpoint, the APIKey filter will fire and reject if it doesn't find an API key
    in the table
- Implement better DTO
  - Use this DTO elsewhere in the program
  - Make the service layer return DTOs when possible
- Finish CRUD operations
- Style classes with section headers