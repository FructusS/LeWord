using LeWord.Entities;

namespace LeWord.Interfaces
{
    public interface IJwtUtils
    {
        public  string generateToken(User user);
        public string validateToken();
    }
}
