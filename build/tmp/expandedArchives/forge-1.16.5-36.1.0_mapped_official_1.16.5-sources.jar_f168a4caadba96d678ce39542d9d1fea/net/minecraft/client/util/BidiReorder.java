package net.minecraft.client.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import java.util.List;
import java.util.Optional;
import java.util.function.UnaryOperator;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.text.ITextProperties;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextProcessing;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BidiReorder {
   private final String plainText;
   private final List<Style> charStyles;
   private final Int2IntFunction reverseCharModifier;

   private BidiReorder(String p_i242079_1_, List<Style> p_i242079_2_, Int2IntFunction p_i242079_3_) {
      this.plainText = p_i242079_1_;
      this.charStyles = ImmutableList.copyOf(p_i242079_2_);
      this.reverseCharModifier = p_i242079_3_;
   }

   public String getPlainText() {
      return this.plainText;
   }

   public List<IReorderingProcessor> substring(int p_244287_1_, int p_244287_2_, boolean p_244287_3_) {
      if (p_244287_2_ == 0) {
         return ImmutableList.of();
      } else {
         List<IReorderingProcessor> list = Lists.newArrayList();
         Style style = this.charStyles.get(p_244287_1_);
         int i = p_244287_1_;

         for(int j = 1; j < p_244287_2_; ++j) {
            int k = p_244287_1_ + j;
            Style style1 = this.charStyles.get(k);
            if (!style1.equals(style)) {
               String s = this.plainText.substring(i, k);
               list.add(p_244287_3_ ? IReorderingProcessor.backward(s, style, this.reverseCharModifier) : IReorderingProcessor.forward(s, style));
               style = style1;
               i = k;
            }
         }

         if (i < p_244287_1_ + p_244287_2_) {
            String s1 = this.plainText.substring(i, p_244287_1_ + p_244287_2_);
            list.add(p_244287_3_ ? IReorderingProcessor.backward(s1, style, this.reverseCharModifier) : IReorderingProcessor.forward(s1, style));
         }

         return p_244287_3_ ? Lists.reverse(list) : list;
      }
   }

   public static BidiReorder create(ITextProperties p_244290_0_, Int2IntFunction p_244290_1_, UnaryOperator<String> p_244290_2_) {
      StringBuilder stringbuilder = new StringBuilder();
      List<Style> list = Lists.newArrayList();
      p_244290_0_.visit((p_244289_2_, p_244289_3_) -> {
         TextProcessing.iterateFormatted(p_244289_3_, p_244289_2_, (p_244288_2_, p_244288_3_, p_244288_4_) -> {
            stringbuilder.appendCodePoint(p_244288_4_);
            int i = Character.charCount(p_244288_4_);

            for(int j = 0; j < i; ++j) {
               list.add(p_244288_3_);
            }

            return true;
         });
         return Optional.empty();
      }, Style.EMPTY);
      return new BidiReorder(p_244290_2_.apply(stringbuilder.toString()), list, p_244290_1_);
   }
}