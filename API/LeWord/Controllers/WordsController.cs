using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using LeWord.Models;
using System.Collections.ObjectModel;
using LeWord.Entities;

namespace LeWord.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class WordsController : ControllerBase
    {
        private readonly LeWordContext _context;


        public WordsController(LeWordContext context)
        {
            _context = context;
            
        }

        // GET: api/Words
        [HttpGet]
        public async Task<ActionResult<List<Word>>> GetWords([FromQuery]int countWords)
        {
            List<Word> words = new List<Word>();
         
            while (countWords != 0)
            {
                foreach (var item in _context.Words.Skip(Random.Shared.Next(1, _context.Words.Count())).Take(1).ToList())
                {
                    words.Add(item);
                }
                countWords--;
            }
            return words;
        }

        // GET: api/Words/5
        //[HttpGet("{id}")]
        //public async Task<ActionResult<Word>> GetWord(int id)
        //{
        //    var word = await _context.Words.FindAsync(id);

        //    if (word == null)
        //    {
        //        return NotFound();
        //    }

        //    return word;
        //}

        // PUT: api/Words/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutWord(int id, Word word)
        {
            if (id != word.Id)
            {
                return BadRequest();
            }

            _context.Entry(word).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!WordExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Words
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Word>> PostWord(Word word)
        {
            _context.Words.Add(word);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetWord", new { id = word.Id }, word);
        }

        // DELETE: api/Words/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteWord(int id)
        {
            var word = await _context.Words.FindAsync(id);
            if (word == null)
            {
                return NotFound();
            }

            _context.Words.Remove(word);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool WordExists(int id)
        {
            return _context.Words.Any(e => e.Id == id);
        }
    }
}
