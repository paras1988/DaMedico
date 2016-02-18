package com.Patterns;
import java.util.List;
/*
Rules:
		Any live cell with fewer than two live neighbors dies, as if caused by under-population.
		Any live cell with two or three live neighbors’ lives on to the next generation.
		Any live cell with more than three live neighbors dies, as if by overcrowding.
		Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
		
		State: DEAD or ALIVE
		Deal with States and handle change in states
*/
public class GameOfLifeStatePattern {}

class State{}
class Alive extends State{}
class Dead extends State{}

class Cell{
	State state;
	List<Cell> neighbors;
	int row;
	int col;
}
class Universe{
	private int _dimRow, _dimCol;
    private List<Cell> _cells;
    
    public Universe(int DimRow, int DimCol, List<Cell> Cells)
    {
        _dimRow = DimRow;
        _dimCol = DimCol;
        _cells = Cells;            
    }
	void setNeighborsOfCells(){
		for(Cell cell:_cells){
			cell.neighbors.add(new Cell());
		}
	}
}