using Microsoft.IdentityModel.Tokens;
using System.Text;

namespace LeWord.utils
{
    public class AuthOptions
    {
        public const string ISSUER = "MyAuthServerFructus"; // издатель токена
        public const string AUDIENCE = "MyAuthClient"; // потребитель токена
        const string KEY = "9EC592E6CF22A959437D7B96C14F0805FFE563CB3797E0379071E0967EA81710==";   // ключ для шифрации
        public const int LIFETIME = 30; // время жизни токена - 30 days
        public static SymmetricSecurityKey GetSymmetricSecurityKey()
        {
            return new SymmetricSecurityKey(Encoding.ASCII.GetBytes(KEY));
        }
    }
}
