using System;
using System.Collections.Generic;

namespace LeWord.Entities;

public partial class Gender
{
    public int Id { get; set; }

    public string Title { get; set; } = null!;

    public virtual ICollection<User> Users { get; } = new List<User>();
}
