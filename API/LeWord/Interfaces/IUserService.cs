

using LeWord.Entities;
using LeWord.Entities.Requests;
using LeWord.Entities.Response;

namespace LeWord.Interfaces
{
    public interface IUserService
    {
        Task<LoginResponse> loginUser(LoginRequest loginRequest);
        Task<RegistrationResponse> registrationUser(RegistrationRequest registrationRequest);
    }
}
