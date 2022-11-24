using Microsoft.IdentityModel.Tokens;
using System.Text;

namespace LeWord
{
    public class AuthOptions
    {
        public const string ISSUER = "MyAuthServerFructus"; // издатель токена
        public const string AUDIENCE = "MyAuthClient"; // потребитель токена
        const string KEY = "1392_+#&!$%FHRYF373192732813$@##&718374230a*#&!#dasd9sda0dsadjad7ad6a7!";   // ключ для шифрации
        public const int LIFETIME = 30; // время жизни токена - 30 days
        public static SymmetricSecurityKey GetSymmetricSecurityKey()
        {
            return new SymmetricSecurityKey(Encoding.ASCII.GetBytes(KEY));
        }
    }
}
