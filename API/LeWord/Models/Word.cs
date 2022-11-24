using System;
using System.Collections.Generic;

namespace LeWord.Models;

public partial class Word
{
    public int Id { get; set; }

    public string Wordoneng { get; set; } = null!;

    public string Wordonrus { get; set; } = null!;

    public string? Transcription { get; set; }
}
