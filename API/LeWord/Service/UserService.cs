using AutoMapper;
using LeWord.Entities;
using LeWord.Entities.Requests;
using LeWord.Entities.Response;
using LeWord.Interfaces;
using LeWord.Models;
using LeWord.utils;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace LeWord.Service
{
    public class UserService : IUserService
    {
        private readonly LeWordContext _context;

        public UserService(LeWordContext context)
        {
            _context = context;
        

        }
        public async Task<LoginResponse> loginUser(LoginRequest loginRequest)
        {
            //получаем пользователя в базе данных 
            var user = _context.Users.SingleOrDefault(user => user.Username == loginRequest.Username);
            //если пользователя с таким никнеймом нет или пароли не совпадают вовзращаем null
            if (user == null || !BCrypt.Net.BCrypt.Verify(loginRequest.Password, user.Passwordhash))
            {
                return null;
            }
            //генерируем jwt token для пользователя 
            string? token = JwtUtils.generateToken(user);

            //возвращаем  пользователя с токеном
            return new LoginResponse { Username = loginRequest.Username, Token = token };
        }



        public async Task<RegistrationResponse> registrationUser(RegistrationRequest registrationRequest)
        {
            if (_context.Users.FirstOrDefault(x => x.Username == registrationRequest.Username) != null)
            {
                return null;
            }
            User user = new User()
            {

                Username = registrationRequest.Username,
                Passwordhash = BCrypt.Net.BCrypt.HashPassword(registrationRequest.Password),
                Email = registrationRequest.Email
            };

            _context.Users.Add(user);
            _context.SaveChangesAsync();
            return new RegistrationResponse { UserName = user.Username, Email = user.Email };
        }
    }
}
