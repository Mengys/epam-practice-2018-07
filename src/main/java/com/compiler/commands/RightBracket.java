package com.compiler.commands;

import com.compiler.Compiler;
import jdk.internal.org.objectweb.asm.tree.InsnNode;
import jdk.internal.org.objectweb.asm.tree.JumpInsnNode;
import jdk.internal.org.objectweb.asm.tree.VarInsnNode;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class RightBracket implements Command {

    @Override
    public int add(String code, int currentCell) {
        return 0;
    }

    @Override
    public void execute(int numOfCommands) {

        Compiler.currentBracket--;
        Compiler.bytecode.add(new VarInsnNode(ALOAD,1));
        Compiler.bytecode.add(new VarInsnNode(ILOAD,2));
        Compiler.bytecode.add(new InsnNode(IALOAD));
        Compiler.bytecode.add(new JumpInsnNode(IFNE,Compiler.leftBrackets.get(Compiler.currentBracket)));
        Compiler.bytecode.add(Compiler.rightBrackets.get(Compiler.currentBracket));

        Compiler.leftBrackets.remove(Compiler.currentBracket);
        Compiler.rightBrackets.remove(Compiler.currentBracket);
    }

    @Override
    public int optimize(String code, int currentCell) {
        return 1;
    }
}
