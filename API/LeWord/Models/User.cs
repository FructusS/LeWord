using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.Text.Json.Serialization;

namespace LeWord.Models;

public partial class User 
{
    public int Id { get; set; }

    public string Username { get; set; } = null!;
    [JsonIgnore]
    public string Passwordhash { get; set; }

    public string? Email { get; set; }

    public string? Firstname { get; set; }

    public string? Lastname { get; set; }

    public int? GenderId { get; set; }

    public virtual Gender? Gender { get; set; }
}
