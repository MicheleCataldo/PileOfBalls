package esami.ia.dlv;

public class IA {
	java.util.ArrayList<esami.ia.pileofballs.ListaSeven> risultato;
	java.util.ArrayList<esami.ia.pileofballs.ListaSeven> vuoto;
	
	public IA(){}
	
	public java.util.ArrayList<esami.ia.pileofballs.ListaSeven> scegliPosizione(java.util.ArrayList<esami.ia.pileofballs.Lista> occupati, java.util.ArrayList<esami.ia.pileofballs.Lista> tripla, java.util.ArrayList<esami.ia.pileofballs.Lista> triplasucc, java.util.ArrayList<esami.ia.pileofballs.Pair> costo, java.util.ArrayList<esami.ia.pileofballs.Tris> libere){
		
		this.risultato = new java.util.ArrayList<esami.ia.pileofballs.ListaSeven>();
		this.vuoto = new java.util.ArrayList<esami.ia.pileofballs.ListaSeven>();
		
		// ---- START - startProgram ---- 
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Creation EXECUTING JDLV module.");
		it.unical.mat.wrapper.DLVInputProgram _JDLV_PROGRAM_EXECUTING=new it.unical.mat.wrapper.DLVInputProgramImpl();
		_JDLV_PROGRAM_EXECUTING.cleanText();
		java.lang.StringBuffer _JDLV_PROGRAM_BUFFER_EXECUTING=new java.lang.StringBuffer();
		it.unical.mat.wrapper.DLVInvocation _JDLV_INVOCATION_EXECUTING;

		// ---- END - startProgram ---- 
		
		// ---- START - addInMapping ---- 
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(occupati,"occ"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'occupati::occ' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(occupati,"occ"), 0));
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(tripla,"el"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'tripla::el' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(tripla,"el"), 0));
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(triplasucc,"elsucc"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'triplasucc::elsucc' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(triplasucc,"elsucc"), 0));
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(costo,"costop"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'costo::costop' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(costo,"costop"), 0));
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(libere,"poslibere"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'libere::poslibere' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(libere,"poslibere"), 0));

		// ---- END - addInMapping ---- 
		
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add out-mapping 'risultato::scelta' in module EXECUTING.");
		
		try{

			_JDLV_INVOCATION_EXECUTING=it.unical.mat.wrapper.DLVWrapper.getInstance().createInvocation(it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath());
			_JDLV_PROGRAM_EXECUTING.addText(_JDLV_PROGRAM_BUFFER_EXECUTING.toString());
			_JDLV_PROGRAM_EXECUTING.getFiles().clear();
			_JDLV_PROGRAM_EXECUTING.addText("pari(0)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pari(2)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pari(4)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pari(6)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pari(8)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pari(10)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("dispari(1)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("dispari(3)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("dispari(5)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("dispari(7)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("dispari(9)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("dispari(11)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("sc(ID,I,J,COL) v nosc(ID,I,J,COL) :- occ(ID,I,J,COL)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("coloritripla(COL) :- el(_,_,_,COL)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":- not #count{ID:sc(ID,_,_,_)} = 1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":- sc(_,_,_,COL), not coloritripla(COL)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("vicini(ID,V,COL) :- sc(ID,I1,J1,_), occ(V,I2,J2,COL), I1=I2, J2=J1+1, ID<>V."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("vicini(ID,V,COL) :- sc(ID,I1,J1,_), occ(V,I2,J2,COL), I1=I2, J2=J1-1, ID<>V."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("vicini(ID,V,COL) :- sc(ID,I1,J1,_), occ(V,I2,J2,COL), J1=J2, I2=I1-1, ID<>V."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("vicini(ID,V,COL) :- sc(ID,I1,J1,_), occ(V,I2,J2,COL), J1=J2, I2=I1+1, ID<>V."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("vicini(ID,V,COL) :- sc(ID,I1,J1,_), occ(V,I2,J2,COL), dispari(I1), I2=I1-1, J2=J1-1, ID<>V."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("vicini(ID,V,COL) :- sc(ID,I1,J1,_), occ(V,I2,J2,COL), dispari(I1), I2=I1+1, J2=J1-1, ID<>V."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("vicini(ID,V,COL) :- sc(ID,I1,J1,_), occ(V,I2,J2,COL), pari(I1), I2=I1+1, J2=J1+1, ID<>V."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("vicini(ID,V,COL) :- sc(ID,I1,J1,_), occ(V,I2,J2,COL), pari(I1), I2=I1-1, J2=J1+1, ID<>V."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("vicinidiversi(ID,V) :- sc(ID,_,_,COL1), vicini(ID,V,COL2), COL1<>COL2."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("maxvicini(ID,M) :- sc(ID,I,J,_), I=11, J>0, J<9, M=4."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("maxvicini(ID,M) :- sc(ID,I,J,_), dispari(I), J=0, M=3."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("maxvicini(ID,M) :- sc(ID,I,J,_), dispari(I), J>7, M=3."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("maxvicini(ID,M) :- sc(ID,I,J,_), pari(I), J=0, M=5."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("maxvicini(ID,M) :- sc(ID,I,J,_), pari(I), J>7, M=5."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("maxvicini(ID,M) :- sc(ID,I,J,_), I=11, J=0, M=2."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("maxvicini(ID,M) :- sc(ID,I,J,_), I=11, J=9, M=2."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("maxvicini(ID,M) :- sc(ID,I,J,_), I<11, J>0, J<8, M=6."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("eldiversi(ID, COL2) :- sc(_,_,_,COL1), el(ID,_,_,COL2), COL1<>COL2."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":- #count{V:vicini(_,V,_)} = M, maxvicini(_,M)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":~ vicinidiversi(ID,V). [1:1]"+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":~ vicini(ID,V,COL). [1:1]"+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":~ eldiversi(ID,COL). [1:2]"+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":~ eldiversi(ID,COL1), vicini(_,V,COL2), vicinidiversi(_,V), COL1<>COL2. [1:2]"+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":~ el(ID1,_,_,COL1), elsucc(ID2,_,_,COL2), COL1<>COL2. [1:2]"+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":~ costop(ID, C), sc(ID,_,_,_). [C:3]"+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("c(COL) :- sc(_,_,_,COL), el(_,_,_,COL)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I1,J,_), poslibere(I1,J1,_), poslibere(I,J1,_), poslibere(I1,J2,_), I1=I-1, J1=J-1, J2=J-2, A=1, B=2, c(C), dispari(I), J>1, J<>9."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I1,J,_), poslibere(I1,J1,_), occ(_,I,J1,_), poslibere(I1,J2,_), I1=I-1, J1=J-1, J2=J-2, A=1, B=2, c(C), dispari(I), J>1, J<>9."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I1,J,_), poslibere(I1,J1,_), occ(_,I,J1,_), occ(_,I1,J2,_), I1=I-1, J1=J-1, J2=J-2, A=1, B=1, c(C), dispari(I), J>1, J<>9."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I1,J,_), occ(_,I1,J1,_), poslibere(I,J2,_), poslibere(I1,J2,_), I1=I-1, J1=J-1, J2=J+1, A=0, B=1, c(C), dispari(I), J<>0, J<>9."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I1,J,_), occ(_,I1,J1,_), occ(_,I,J2,_), poslibere(I1,J2,_), I1=I-1, J1=J-1, J2=J+1, A=0, B=1, c(C), dispari(I), J<>0, J<>9."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I1,J,_), occ(_,I1,J1,_), occ(_,I,J2,_), occ(_,I1,J2,_), I1=I-1, J1=J-1, J2=J+1, A=0, B=1, c(C), dispari(I), J<>0, J<>9."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), poslibere(I,J2,_), poslibere(I,J3,_), poslibere(I,J4,_), J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=1, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I,J2,_), poslibere(I,J3,_), occ(_,I,J4,COL), J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=2, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I,J2,_), poslibere(I,J3,_), occ(_,I,J4,COL1), J1=J-1, J2=J+1, J3=J-2, J4=J+2, COL<>COL1, A=0, B=1, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I,J3,COL), poslibere(I,J4,_), J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=1, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I,J3,COL1), poslibere(I,J4,_), J1=J-1, J2=J+1, J3=J-2, J4=J+2, COL<>COL1, A=0, B=2, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I,J3,_), poslibere(I,J4,_), I1=I-1,  J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=0, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I,J3,_), occ(_,I,J4,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=1, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,COL), poslibere(I1,J,_), occ(_,I,J3,COL), poslibere(I,J4,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=1, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,COL), poslibere(I1,J,_), occ(_,I,J3,COL1), poslibere(I,J4,_), I1=I-1, COL<>COL1,  J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=0, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,COL1), poslibere(I1,J,_), occ(_,I,J3,COL), poslibere(I,J4,_), I1=I-1, COL<>COL1,  J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=1, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,COL1), poslibere(I1,J,_), occ(_,I,J3,COL2), poslibere(I,J4,_), I1=I-1, COL<>COL1, COL<>COL2,  J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=0, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), occ(_,I,J2,_), poslibere(I1,J1,_), occ(_,I,J3,_), occ(_,I,J4,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=1, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), poslibere(I,J2,_), poslibere(I1,J1,_), poslibere(I,J3,_), poslibere(I,J4,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=1, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), poslibere(I,J2,_), poslibere(I1,J1,_), occ(_,I,J3,_), poslibere(I,J4,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=1, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), poslibere(I,J2,_), poslibere(I1,J1,_), poslibere(I,J3,_), occ(_,I,J4,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=0, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), poslibere(I,J2,_), poslibere(I1,J1,_), occ(_,I,J3,_), occ(_,I,J4,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=0, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL), occ(_,I,J2,COL), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J3,_), poslibere(I,J4,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=2, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL1), occ(_,I,J2,COL2), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J3,_), poslibere(I,J4,_), COL1<>COL, COL2<>COL, I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=2, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL1), occ(_,I,J2,COL), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J3,_), poslibere(I,J4,_), COL1<>COL, I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=0, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL), occ(_,I,J2,COL2), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J3,_), poslibere(I,J4,_), COL2<>COL, I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=1, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J3,_), occ(_,I,J4,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=1, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), occ(_,I,J2,COL), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J3,_), occ(_,I,J4,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=0, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J3,_), occ(_,I,J4,COL), I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=0, B=2, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J3,_), poslibere(I,J4,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=1, B=0, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), occ(_,I,J2,COL), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J3,_), poslibere(I,J4,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=1, B=2, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J3,COL), poslibere(I,J4,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=1, B=1, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J3,_), occ(_,I,J4,_), poslibere(I1,J2,_), poslibere(I1,J3,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=1, B=0, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J3,_), occ(_,I,J4,_), poslibere(I1,J2,_), occ(_,I1,J3,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=1, B=0, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J3,_), occ(_,I,J4,_), occ(_,I1,J2,_), poslibere(I1,J3,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=1, B=0, c(C), dispari(I), J>1, J<8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J3,_), occ(_,I,J4,_), occ(_,I1,J2,_), occ(_,I1,J3,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2, J4=J+2, A=1, B=0, c(C), dispari(I), J>1, J<8."+'\n');	
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), poslibere(I,J2,_), poslibere(I1,J1,_), poslibere(I1,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, A=0, B=0, c(C), pari(I), J<>0, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), poslibere(I,J2,_), poslibere(I1,J1,_), occ(_,I1,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, A=0, B=0, c(C), pari(I), J<>0, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), poslibere(I1,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, A=0, B=0, c(C), pari(I), J<>0, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), poslibere(I,J4,_), poslibere(I,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, A=0, B=0, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,COL), poslibere(I,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, A=0, B=1, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL1), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,COL2), poslibere(I,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, COL1<>COL2, A=0, B=0, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), poslibere(I,J4,_), occ(_,I,J3,COL), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, A=0, B=2, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL1), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), poslibere(I,J4,_), occ(_,I,J3,COL2), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, COL1<>COL2, A=0, B=0, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,COL), occ(_,I,J3,COL2), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, COL<>COL2, A=0, B=1, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,COL3), occ(_,I,J3,COL), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, COL<>COL3, A=0, B=2, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,COL), occ(_,I,J3,COL), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, A=0, B=2, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), poslibere(I,J4,_), poslibere(I,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, A=0, B=1, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,_), poslibere(I,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, A=0, B=1, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), poslibere(I,J4,_), occ(_,I,J3,COL), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, A=0, B=2, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), poslibere(I,J4,_), occ(_,I,J3,COL1), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, COL<>COL1, A=0, B=1, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,COL), occ(_,I,J3,COL1), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, COL<>COL1, A=0, B=1, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,COL2), occ(_,I,J3,COL1), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, COL<>COL1, COL<>COL2, A=0, B=1, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,COL2), occ(_,I,J3,COL), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, COL<>COL2, A=0, B=2, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,COL), occ(_,I,J3,COL), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, A=0, B=1, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL1), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,COL), occ(_,I,J3,COL), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, COL<>COL1, A=0, B=2, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), poslibere(I,J4,_), poslibere(I,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, A=0, B=2, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), poslibere(I,J4,_), occ(_,I,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, A=0, B=2, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,_), poslibere(I,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, A=0, B=2, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,COL2), occ(_,I,J3,COL1), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, COL<>COL1, COL<>COL2, A=0, B=2, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,COL2), occ(_,I,J3,COL), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, COL<>COL2, A=0, B=2, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,COL), occ(_,I,J3,COL1), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, COL<>COL1, A=0, B=1, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,COL), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,COL), occ(_,I,J3,COL), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, A=0, B=2, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,COL1), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,COL), occ(_,I,J3,COL), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, COL<>COL1, A=0, B=1, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), poslibere(I,J4,_), poslibere(I,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, A=0, B=1, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,_), poslibere(I,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, A=0, B=1, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), poslibere(I,J4,_), occ(_,I,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, A=0, B=2, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,_), occ(_,I,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, J4=J-2, A=0, B=2, c(C), pari(I), J>1, J<7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), poslibere(I,J2,_), J1=J+1, J2=J+2, A=0, B=1, c(C), dispari(I), J=0."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I1,J,_), occ(_,I,J1,_), poslibere(I,J2,_), I1=I-1, J1=J+1, J2=J+2, A=0, B=1, c(C), dispari(I), J=0."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I1,J,_), poslibere(I,J1,_), occ(_,I,J2,_), I1=I-1, J1=J+1, J2=J+2, A=0, B=1, c(C), dispari(I), J=0."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J1,_), occ(_,I,J2,_), I1=I-1, J1=J+1, J2=J+2, A=0, B=1, c(C), dispari(I), J=0."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I1,J,_), occ(_,I1,J1,_), I1=I-1, J1=J+1, A=0, B=1, c(C), dispari(I), J=0."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), poslibere(I,J2,_), J1=J-1, J2=J-2, A=0, B=2, c(C), dispari(I), J=9."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I1,J1,_), occ(_,I,J1,_), poslibere(I,J2,_), I1=I-1, J1=J-1, J2=J-2, A=0, B=2, c(C), dispari(I), J=9."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I1,J1,_), poslibere(I,J1,_), occ(_,I,J2,_), I1=I-1, J1=J-1, J2=J-2, A=0, B=2, c(C), dispari(I), J=9."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I1,J1,_), poslibere(I1,J2,_), occ(_,I,J1,_), occ(_,I,J2,_), I1=I-1, J1=J-1, J2=J-2, A=0, B=0, c(C), dispari(I), J=9."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I1,J1,_), occ(_,I1,J2,_), I1=I-1, J2=J-2, A=0, B=1, c(C), dispari(I), J=9."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), poslibere(I1,J,_), poslibere(I2,J2,_), I1=I-1, I2=I+1, J1=J+1, J2=J+2, A=0, B=0, c(C), pari(I), J=0."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), poslibere(I1,J,_), occ(_,I2,J2,_), poslibere(I,J2,_), I1=I-1, I2=I+1, J1=J+1, J2=J+2, A=0, B=2, c(C), pari(I), J=0."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I1,J,_), occ(_,I2,J2,_), occ(_,I,J2,COL), I1=I-1, I2=I+1, J1=J+1, J2=J+2, A=0, B=2, c(C), pari(I), J=0."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I1,J,_), occ(_,I2,J2,_), occ(_,I,J2,COL1), I1=I-1, I2=I+1, J1=J+1, J2=J+2, COL<>COL1, A=0, B=0, c(C), pari(I), J=0."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), poslibere(I1,J,_), poslibere(I1,J1,_), I1=I-1, I2=I+1, J1=J+1, J2=J+2, A=0, B=2, c(C), pari(I), J=0."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), poslibere(I1,J,_), occ(_,I1,J1,_), I1=I-1, I2=I+1, J1=J+1, J2=J+2, A=0, B=2, c(C), pari(I), J=0."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I1,J,_), poslibere(I1,J1,_), poslibere(I,J2,_), I1=I-1, I2=I+1, J1=J+1, J2=J+2, A=0, B=1, c(C), pari(I), J=0."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I1,J,_), poslibere(I1,J1,_), occ(_,I,J2,_), I1=I-1, I2=I+1, J1=J+1, J2=J+2, A=0, B=1, c(C), pari(I), J=0."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), poslibere(I1,J3,_), poslibere(I2,J2,_), I1=I-1, I2=I+1, J1=J-1, J2=J-2, J3=J+1, A=0, B=2, c(C), pari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), poslibere(I1,J3,_), occ(_,I2,J2,_), poslibere(I,J2,_), I1=I-1, I2=I+1, J1=J-1, J2=J-2,  J3=J+1, A=0, B=2, c(C), pari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I1,J3,_), occ(_,I2,J2,_), occ(_,I,J2,COL), I1=I-1, I2=I+1, J1=J-1, J2=J-2,  J3=J+1, A=0, B=1, c(C), pari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I1,J3,_), occ(_,I2,J2,_), occ(_,I,J2,COL1), I1=I-1, I2=I+1, J1=J-1, J2=J-2,  J3=J+1, COL<>COL1, A=0, B=2, c(C), pari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), poslibere(I1,J3,_), poslibere(I1,J,_), I1=I-1, I2=I+1, J1=J-1, J2=J-2, J3=J+1, A=0, B=1, c(C), pari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), poslibere(I1,J3,_), occ(_,I1,J,_), I1=I-1, I2=I+1, J1=J-1, J2=J-2, A=0, B=0, J3=J+1, c(C), pari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I1,J3,_), poslibere(I1,J,_), poslibere(I,J2,_), I1=I-1, I2=I+1, J1=J-1, J2=J-2, J3=J+1, A=1, B=1, c(C), pari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I1,J3,_), poslibere(I1,J,_), occ(_,I,J2,_), I1=I-1, I2=I+1, J1=J-1, J2=J-2, J3=J+1, A=1, B=1, c(C), pari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I1,J,_), poslibere(I1,J1,_), poslibere(I,J1,_), I1=I-1, J1=J-1, A=1, B=2, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I1,J,_), poslibere(I1,J1,_), occ(_,I,J1,_), I1=I-1, J1=J-1, A=1, B=2, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I1,J,_), poslibere(I1,J1,_), occ(_,I,J1,_), I1=I-1, J1=J-1, A=1, B=1, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), poslibere(I,J2,_), poslibere(I,J4,_), J1=J-1, J2=J+1, J4=J+2, A=0, B=1, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I,J4,COL), J1=J-1, J2=J+1, J4=J+2, A=0, B=2, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I,J4,COL1), J1=J-1, J2=J+1, J4=J+2, COL<>COL1, A=0, B=1, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I,J2,_), poslibere(I,J4,_), J1=J-1, J2=J+1, J4=J+2, A=0, B=2, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I,J4,_), I1=I-1,  J1=J-1, J2=J+1, J4=J+2, A=0, B=0, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), occ(_,I,J4,_), I1=I-1, J1=J-1, J2=J+1, J4=J+2, A=0, B=1, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,COL), poslibere(I1,J,_), poslibere(I,J4,_), I1=I-1, J1=J-1, J2=J+1, J4=J+2, A=0, B=0, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,COL1), poslibere(I1,J,_), poslibere(I,J4,_), I1=I-1, COL<>COL1, J1=J-1, J2=J+1,  J4=J+2, A=0, B=0, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), occ(_,I,J2,_), poslibere(I1,J1,_), occ(_,I,J4,_), I1=I-1, J1=J-1, J2=J+1,  J4=J+2, A=0, B=1, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), poslibere(I,J2,_), poslibere(I1,J1,_), poslibere(I,J4,_), I1=I-1, J1=J-1, J2=J+1,  J4=J+2, A=0, B=1, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL), occ(_,I,J2,COL), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J4,_), I1=I-1, J1=J-1, J2=J+1,  J4=J+2, A=0, B=2, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL1), occ(_,I,J2,COL2), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J4,_), COL1<>COL, COL2<>COL, I1=I-1, J1=J-1, J2=J+1,  J4=J+2, A=0, B=2, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL1), occ(_,I,J2,COL), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J4,_), COL1<>COL, I1=I-1, J1=J-1, J2=J+1,  J4=J+2, A=0, B=0, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL), occ(_,I,J2,COL2), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J4,_), COL2<>COL, I1=I-1, J1=J-1, J2=J+1,  J4=J+2, A=0, B=1, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J4,_), I1=I-1, J1=J-1, J2=J+1,  J4=J+2, A=0, B=1, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), occ(_,I,J2,COL), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J4,_), I1=I-1, J1=J-1, J2=J+1,  J4=J+2, A=0, B=0, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J4,COL), I1=I-1, J1=J-1, J2=J+1,  J4=J+2, A=0, B=2, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J4,_), I1=I-1, J1=J-1, J2=J+1,  J4=J+2, A=1, B=0, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), occ(_,I,J2,COL), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J4,_), I1=I-1, J1=J-1, J2=J+1,  J4=J+2, A=1, B=2, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J4,_), poslibere(I1,J2,_), I1=I-1, J1=J-1, J2=J+1,  J4=J+2, A=1, B=0, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J4,_), occ(_,I1,J2,_), I1=I-1, J1=J-1, J2=J+1,  J4=J+2, A=1, B=0, c(C), dispari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), poslibere(I,J2,_), poslibere(I,J3,_), J1=J-1, J2=J+1, J3=J-2, A=0, B=1, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I,J3,COL), J1=J-1, J2=J+1, J3=J-2,  A=0, B=1, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I,J3,COL1), J1=J-1, J2=J+1, J3=J-2,  COL<>COL1, A=0, B=2, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I,J3,_), I1=I-1,  J1=J-1, J2=J+1, J3=J-2,  A=0, B=0, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,COL), poslibere(I1,J,_), occ(_,I,J3,COL), I1=I-1, J1=J-1, J2=J+1, J3=J-2,  A=0, B=1, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,COL), poslibere(I1,J,_), occ(_,I,J3,COL1), poslibere(I,J4,_), I1=I-1, COL<>COL1,  J1=J-1, J2=J+1, J3=J-2,  A=0, B=0, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,COL1), poslibere(I1,J,_), occ(_,I,J3,COL), I1=I-1, COL<>COL1,  J1=J-1, J2=J+1, J3=J-2,  A=0, B=1, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,COL1), poslibere(I1,J,_), occ(_,I,J3,COL2), I1=I-1, COL<>COL1, COL<>COL2,  J1=J-1, J2=J+1, J3=J-2,  A=0, B=0, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), poslibere(I,J2,_), poslibere(I1,J1,_), poslibere(I,J3,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2,  A=0, B=1, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), poslibere(I,J2,_), poslibere(I1,J1,_), occ(_,I,J3,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2,  A=0, B=0, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL), occ(_,I,J2,COL), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J3,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2,  A=0, B=2, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL1), occ(_,I,J2,COL2), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J3,_),COL1<>COL, COL2<>COL, I1=I-1, J1=J-1, J2=J+1, J3=J-2,  A=0, B=2, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL1), occ(_,I,J2,COL), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J3,_), COL1<>COL, I1=I-1, J1=J-1, J2=J+1, J3=J-2,  A=0, B=0, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL), occ(_,I,J2,COL2), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J3,_), COL2<>COL, I1=I-1, J1=J-1, J2=J+1, J3=J-2,  A=0, B=1, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J3,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2,  A=0, B=1, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), occ(_,I,J2,COL), poslibere(I1,J,_), poslibere(I1,J1,_), poslibere(I,J3,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2,  A=0, B=0, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J3,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2,  A=1, B=0, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), occ(_,I,J2,COL), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J3,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2,  A=1, B=2, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J3,COL), I1=I-1, J1=J-1, J2=J+1, J3=J-2,  A=1, B=1, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J3,_), poslibere(I1,J2,_), poslibere(I1,J3,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2,  A=1, B=0, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J3,_), poslibere(I1,J2,_), occ(_,I1,J3,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2,  A=1, B=0, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J3,_), occ(_,I1,J2,_), poslibere(I1,J3,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2,  A=1, B=0, c(C), dispari(I), J=8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I,J2,_), poslibere(I1,J,_), poslibere(I1,J1,_), occ(_,I,J3,_), occ(_,I1,J2,_), occ(_,I1,J3,_), I1=I-1, J1=J-1, J2=J+1, J3=J-2,  A=1, B=0, c(C), dispari(I), J=8."+'\n');

			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), poslibere(I,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, A=0, B=0, c(C), pari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J3,COL), I1=I+1, J1=J-1, J2=J+1, J3=J+2, A=0, B=2, c(C), pari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J3,COL2), I1=I+1, J1=J-1, J2=J+1, J3=J+2, COL<>COL2, A=0, B=1, c(C), pari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), poslibere(I,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, A=0, B=1, c(C), pari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J3,COL), I1=I+1, J1=J-1, J2=J+1, J3=J+2, A=0, B=2, c(C), pari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J3,COL1), I1=I+1, J1=J-1, J2=J+1, J3=J+2, COL<>COL1, A=0, B=1, c(C), pari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J3,COL), I1=I+1, J1=J-1, J2=J+1, J3=J+2, A=0, B=1, c(C), pari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL1), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J3,COL), I1=I+1, J1=J-1, J2=J+1, J3=J+2, COL<>COL1, A=0, B=2, c(C), pari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), poslibere(I,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, A=0, B=2, c(C), pari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2, A=0, B=2, c(C), pari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J3,COL), I1=I+1, J1=J-1, J2=J+1, J3=J+2, A=0, B=2, c(C), pari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J3,COL1), I1=I+1, J1=J-1, J2=J+1, J3=J+2, COL<>COL1, A=0, B=1, c(C), pari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,COL), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J3,COL), I1=I+1, J1=J-1, J2=J+1, J3=J+2, A=0, B=2, c(C), pari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,COL1), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J3,COL), I1=I+1, J1=J-1, J2=J+1, J3=J+2, COL<>COL1, A=0, B=1, c(C), pari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), poslibere(I,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2,  A=0, B=1, c(C), pari(I), J=1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J3,_), I1=I+1, J1=J-1, J2=J+1, J3=J+2,  A=0, B=2, c(C), pari(I), J=1."+'\n');
			
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), poslibere(I,J2,_), poslibere(I1,J1,_), I1=I+1, J1=J-1, J2=J+1, A=0, B=0, c(C), pari(I), J=7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), I1=I+1, J1=J-1, J2=J+1, A=0, B=0, c(C), pari(I), J=7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_),  poslibere(I,J4,_), I1=I+1, J1=J-1, J2=J+1, J4=J-2, A=0, B=0, c(C), pari(I), J=7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I,J4,COL), I1=I+1, J1=J-1, J2=J+1, J4=J-2, A=0, B=1, c(C), pari(I), J=7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL1), poslibere(I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I,J4,COL2), I1=I+1, J1=J-1, J2=J+1, J4=J-2, COL1<>COL2, A=0, B=0, c(C), pari(I), J=7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), poslibere(I,J4,_), I1=I+1, J1=J-1, J2=J+1, J4=J-2, A=0, B=1, c(C), pari(I), J=7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I,J4,_), I1=I+1, J1=J-1, J2=J+1, J4=J-2, A=0, B=1, c(C), pari(I), J=7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I,J4,COL), I1=I+1, J1=J-1, J2=J+1, J4=J-2, A=0, B=1, c(C), pari(I), J=7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,_), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I,J4,COL2), I1=I+1, J1=J-1, J2=J+1, J4=J-2, COL<>COL2, A=0, B=1, c(C), pari(I), J=7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,COL), I1=I+1, J1=J-1, J2=J+1, J4=J-2, A=0, B=1, c(C), pari(I), J=7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), occ(_,I,J1,COL1), poslibere(I,J2,_), occ(_,I1,J1,_), occ(_,I1,J3,_), occ(_,I,J4,COL), I1=I+1, J1=J-1, J2=J+1, J4=J-2, COL<>COL1, A=0, B=2, c(C), pari(I), J=7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), poslibere(I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), poslibere(I,J4,_), I1=I+1, J1=J-1, J2=J+1, J4=J-2, A=0, B=2, c(C), pari(I), J=7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I,J4,_), I1=I+1, J1=J-1, J2=J+1, J4=J-2, A=0, B=2, c(C), pari(I), J=7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I,J4,COL2), I1=I+1, J1=J-1, J2=J+1, J4=J-2, COL<>COL2, A=0, B=2, c(C), pari(I), J=7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,COL), occ(_,I1,J1,_), occ(_,I,J4,COL), I1=I+1, J1=J-1, J2=J+1, J4=J-2, A=0, B=2, c(C), pari(I), J=7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,COL), poslibere(I,J1,_), occ(_,I,J2,COL1), occ(_,I1,J1,_), occ(_,I,J4,COL), I1=I+1, J1=J-1, J2=J+1, J4=J-2, COL<>COL1, A=0, B=1, c(C), pari(I), J=7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), poslibere(I,J4,_), I1=I+1, J1=J-1, J2=J+1, J4=J-2, A=0, B=1, c(C), pari(I), J=7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pos(A,B,C) :- sc(_,I,J,_), occ(_,I,J1,_), occ(_,I,J2,_), occ(_,I1,J1,_), occ(_,I,J4,_), I1=I+1, J1=J-1, J2=J+1, J4=J-2, A=0, B=1, c(C), pari(I), J=7."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("postandard(A,B,C) :- A=2, B=1, c(C), sc(_,I,J,_), J < 9, dispari(I)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("postandard(A,B,C) :- A=2, B=1, c(C), sc(_,I,J,_), J < 8, pari(I)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("postandard(A,B,C) :- A=2, B=2, c(C), sc(_,I,J,_), J = 9, dispari(I)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("postandard(A,B,C) :- A=2, B=2, c(C), sc(_,I,J,_), J = 8, pari(I)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("scelta(ID,I,J,COL,A,B,C) :- sc(ID,I,J,COL), pos(A,B,C)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("scelta(ID,I,J,COL,A,B,C) :- sc(ID,I,J,COL), postandard(A,B,C)."+'\n');
			_JDLV_PROGRAM_BUFFER_EXECUTING.append("");
			_JDLV_INVOCATION_EXECUTING.setInputProgram(_JDLV_PROGRAM_EXECUTING);
			it.unical.mat.wrapper.ModelBufferedHandler _BUFFERED_HANDLER_EXECUTING=new it.unical.mat.wrapper.ModelBufferedHandler(_JDLV_INVOCATION_EXECUTING);
			it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Start execution EXECUTING program: executablePath='"+it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath()+"', options='"+_JDLV_INVOCATION_EXECUTING.getOptionsString()+"'"+'\n'+"Code execution: "+it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(_JDLV_INVOCATION_EXECUTING.getInputProgram().getCompleteText(),0));
			_JDLV_INVOCATION_EXECUTING.run();
			while(_BUFFERED_HANDLER_EXECUTING.hasMoreModels()){
			it.unical.mat.wrapper.Model _temporary_JDLV_MODELEXECUTING=_BUFFERED_HANDLER_EXECUTING.nextModel();
			it.unical.mat.jdlv.program.TypeSolver.loadPredicate(risultato, "scelta",_temporary_JDLV_MODELEXECUTING,esami.ia.pileofballs.ListaSeven.class);
			it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Process new answer_set"+ '\n' + "Results:"+ '\n'+ "risultato " + risultato.size() + " elements"+ '\n' + it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyObject(risultato,0));
			return risultato;
			}
			if(_JDLV_INVOCATION_EXECUTING.haveModel()==false){
			}
			if(!_JDLV_INVOCATION_EXECUTING.getErrors().isEmpty()){
			throw new java.lang.RuntimeException(_JDLV_INVOCATION_EXECUTING.getErrors().get(0).getText());
			}
			}
			catch(java.lang.Throwable _JDLV_EXCEPTION_EXECUTING){
			it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logErrorMessage(_JDLV_EXCEPTION_EXECUTING.getMessage());
			}
			_JDLV_PROGRAM_EXECUTING.cleanText();

				// ---- END - prepareJDLVCall ---- 
			if(!risultato.isEmpty()){
				System.out.println("Trovato");
				return risultato;
			}	
			else 
				return  vuoto ;
	} 
}
