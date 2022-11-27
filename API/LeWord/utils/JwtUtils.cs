using LeWord.Entities;
using LeWord.Entities.Requests;
using LeWord.Interfaces;
using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;

namespace LeWord.utils
{
  
    public class JwtUtils 
    {
        public static string generateToken(User user)
        {

            var claims = new List<Claim> {
                new Claim(ClaimsIdentity.DefaultNameClaimType, user.Username) ,
                new Claim("Email",user.Email)
            };
            ClaimsIdentity claimsIdentity = new ClaimsIdentity(claims, "Token", ClaimsIdentity.DefaultNameClaimType, ClaimsIdentity.DefaultRoleClaimType);



            // создаем JWT-токен
            var jwt = new JwtSecurityToken(
                    issuer: AuthOptions.ISSUER,
                    audience: AuthOptions.AUDIENCE,

                    claims: claimsIdentity.Claims,
                    expires: DateTime.Now.AddMinutes(30),
                    signingCredentials: new SigningCredentials(AuthOptions.GetSymmetricSecurityKey(), SecurityAlgorithms.HmacSha256));
            var encodedJwt = new JwtSecurityTokenHandler().WriteToken(jwt);
            return encodedJwt;
        }
        public static string validateToken()
        {
            return "";
        }
    }
}
